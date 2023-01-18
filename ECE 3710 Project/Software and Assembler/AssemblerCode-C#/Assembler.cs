using System;
using System.IO;
using System.Text;

namespace Assembler
{
	class Program
	{
		static void Main(string[] args)
		{
			string line;
			using StreamReader file = new StreamReader("program.txt");

			string fileName = @Directory.GetCurrentDirectory() + "\\output.txt";
			try
			{
				if (File.Exists(fileName))
				{
					File.Delete(fileName);
				}

				using StreamWriter sw = File.CreateText(fileName);
				while ((line = file.ReadLine()) != null)
				{
					if (line.StartsWith("//"))
						continue;

					line = line.Trim();

					if (line.Length == 0)
						continue;

					StringBuilder fullInstruction = new StringBuilder();

					string[] splitUp = line.Split();

					fullInstruction.Append(decode(splitUp[0].ToLower()));
					string firstArg = splitUp[1];
					int firstVal;
					string firstBin;
					string hex = "";

					if (splitUp[0].ToLower() == "ldkey")
					{
						int reg = Int32.Parse(firstArg);
						string regValue = Convert.ToString(reg, 2).PadLeft(4, '0');
						fullInstruction.Append(regValue);
						fullInstruction.Append("11110000");
						hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
						sw.WriteLine(hex);
						continue;
					}

					if (splitUp[0].ToLower()[0] == 'j')
					{
						fullInstruction.Append("1100");
						firstVal = Int32.Parse(firstArg);
						firstBin = Convert.ToString(firstVal, 2).PadLeft(4, '0');
						fullInstruction.Append(firstBin);
						hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
						sw.WriteLine(hex);
						continue;
					}
					if (splitUp[0].ToLower()[0] == 'b')
					{
						if (splitUp[0].ToLower()[1] == 'r')
						{
							fullInstruction.Append("1110");
							firstVal = Int32.Parse(firstArg);
							firstBin = Convert.ToString(firstVal, 2).PadLeft(4, '0');
							fullInstruction.Append(firstBin);
							hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
							sw.WriteLine(hex);
							continue;
						}
						firstVal = Int32.Parse(firstArg.Substring(1, firstArg.Length - 1));
						firstBin = Convert.ToString(firstVal, 2).PadLeft(8, '0');
						fullInstruction.Append(firstBin);
						hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
						sw.WriteLine(hex);
						continue;
					}

					string immOp = "";
					bool immediate = false;
					int secondVal;
					string secondBin;

					if (fullInstruction.Equals("1000"))
					{
						if (firstArg[0] == '$')
						{
							secondVal = Int32.Parse(firstArg.Substring(1, firstArg.Length - 2));
							secondBin = Convert.ToString(secondVal, 2).PadLeft(4, '0');
							firstVal = Int32.Parse(splitUp[2]);
							firstBin = Convert.ToString(firstVal, 2).PadLeft(4, '0');
						}
						else
						{
							firstVal = Int32.Parse(firstArg.Substring(0, firstArg.Length - 1));
							firstBin = Convert.ToString(firstVal, 2).PadLeft(4, '0');
							secondVal = Int32.Parse(splitUp[2]);
							secondBin = Convert.ToString(secondVal, 2).PadLeft(4, '0');
						}
						fullInstruction.Append(firstBin);
						fullInstruction.Append(shiftDecode(splitUp[0].ToLower()));
						fullInstruction.Append(secondBin);
						hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
						sw.WriteLine(hex);
						continue;
					}
					else if (firstArg[0] == '$')
					{
						immediate = true;
						firstArg = firstArg.Substring(1, firstArg.Length - 2);
						firstVal = Int32.Parse(firstArg);
						firstBin = Convert.ToString(firstVal, 2).PadLeft(8, '0');
					}
					else
					{
						if (splitUp[0].ToLower() == "stor" || splitUp[0].ToLower() == "load")
						{
							if (splitUp[0].ToLower() == "stor")
							{
								immediate = true;
								firstArg = firstArg.Substring(0, firstArg.Length - 1);
								firstVal = Int32.Parse(firstArg);
								firstBin = Convert.ToString(firstVal, 2).PadLeft(4, '0');
								fullInstruction.Append(firstBin);
								fullInstruction.Append("0100");
								secondVal = Int32.Parse(splitUp[2]);
								secondBin = Convert.ToString(secondVal, 2).PadLeft(4, '0');
								fullInstruction.Append(secondBin);
								hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
								sw.WriteLine(hex);
								continue;
							}
							else
							{
								immediate = true;
								firstArg = firstArg.Substring(0, firstArg.Length - 1);
								firstVal = Int32.Parse(firstArg);
								firstBin = Convert.ToString(firstVal, 2).PadLeft(4, '0');
								fullInstruction.Append(firstBin);
								fullInstruction.Append("0000");
								secondVal = Int32.Parse(splitUp[2]);
								secondBin = Convert.ToString(secondVal, 2).PadLeft(4, '0');
								fullInstruction.Append(secondBin);
								hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
								sw.WriteLine(hex);
								continue;
							}
						}
						else
						{

							immediate = false;
							firstArg = firstArg.Substring(0, firstArg.Length - 1);
							firstVal = Int32.Parse(firstArg);
							firstBin = Convert.ToString(firstVal, 2).PadLeft(4, '0');

							immOp = opcodeDecode(splitUp[0].ToLower() + "i");
						}
					}

					secondVal = Int32.Parse(splitUp[2]);
					secondBin = Convert.ToString(secondVal, 2).PadLeft(4, '0');

					if (immediate)
					{
						fullInstruction.Append(secondBin);
						fullInstruction.Append(firstBin);
					}
					else
					{
						fullInstruction.Append(firstBin);
						fullInstruction.Append(immOp);
						fullInstruction.Append(secondBin);
					}
					hex = String.Format("{0:X2}", Convert.ToUInt64(fullInstruction.ToString(), 2));
					sw.WriteLine(hex);
				}
			}
			catch (Exception e)
			{
				Console.WriteLine(e.ToString());
			}

		}

		static string decode(string s)
		{

			StringBuilder instruction = new StringBuilder();

			if (s[0] == 'j')
			{
				instruction.Append("0100");
				string cond = s.Substring(1, 2);
				instruction.Append(conditionDecode(cond));
				return instruction.ToString();
			}

			else if (s[0] == 'b')
			{
				if (s[1] == 'r')
				{
					instruction.Append("0100");
					string cond = s.Substring(2, 2);
					instruction.Append(conditionDecode(cond));
					return instruction.ToString();
				}
				else
				{
					instruction.Append("1100");
					string cond = s.Substring(1, 2);
					instruction.Append(conditionDecode(cond));
					return instruction.ToString();
				}
			}

			else
			{
				instruction.Append(opcodeDecode(s));
				return instruction.ToString();
			}
		}

		static string conditionDecode(string s)
		{
			switch (s)
			{
				case "eq":
					return "0000";
				case "ne":
					return "0001";
				case "cs":
					return "0010";
				case "cc":
					return "0011";
				case "hi":
					return "0100";
				case "ls":
					return "0101";
				case "gt":
					return "0110";
				case "le":
					return "0111";
				case "fs":
					return "1100";
				case "fc":
					return "1101";
				case "lo":
					return "1010";
				case "hs":
					return "1011";
				case "lt":
					return "1000";
				case "ge":
					return "1001";
				case "uc":
					return "1110";
				case "no":
					return "1111";
				default:
					return "invalid";
			}
		}

		static string opcodeDecode(string s)
		{
			switch (s)
			{
				case "and":
					return "0000";
				case "andi":
					return "0001";
				case "or":
					return "0000";
				case "ori":
					return "0010";
				case "xor":
					return "0000";
				case "xori":
					return "0011";
				case "addi":
					return "0101";
				case "add":
					return "0000";
				case "addu":
					return "0110";
				case "addc":
					return "0111";
				case "subi":
					return "1001";
				case "sub":
					return "0000";
				case "subc":
					return "1010";
				case "cmp":
					return "0000";
				case "cmpi":
					return "1011";
				case "movi":
					return "1101";
				case "mov":
					return "0000";
				case "not":
					return "0100";
				case "lshi":
					return "1000";
				case "lsh":
					return "1000";
				case "rshi":
					return "1000";
				case "rsh":
					return "1000";
				case "ashui":
					return "1000";
				case "ashu":
					return "1000";
				case "wait":
					return "0000";
				case "li":
					return "1101";
				case "lui":
					return "1111";
				case "load":
					return "0100";
				case "stor":
					return "0100";
				case "ldkey":
					return "0100";
				default:
					return "invalid";
			}
		}

		static string shiftDecode(string s)
		{
			switch (s)
			{
				case "lshi":
					return "0000";
				case "lsh":
					return "0100";
				case "rshi":
					return "0001";
				case "rsh":
					return "0101";
				case "ashui":
					return "0010";
				case "ashu":
					return "0110";
				default:
					return "invalid";
			}
		}
	}
}