using System;
using System.Collections.Generic;
using System.Data;
using System.IO;
using LumenWorks.Framework.IO.Csv;

namespace HexFileGeratorFromCSV
{
    class Program
    {
        static void Main(string[] args)
        {
            var csvTable = new DataTable();
            using (var csvReader = new CsvReader(new StreamReader(System.IO.File.OpenRead(@"Player2MenuCompleteHexadecimalBitmap.csv")), true))
            {
                csvTable.Load(csvReader);
                using (var w = new StreamWriter(@"Player2hexFile.hex"))
                {
                    w.WriteLine("@D000");
                    for (int i = 0; i < csvTable.Rows.Count; i++)
                    {
                        for (int j = 0; j < csvTable.Columns.Count; j++)
                        {
                            string hex = csvTable.Rows[i][j].ToString();
                            w.WriteLine(hex);
                            w.Flush();
                        }
                    }
                }
            }


        }
    }
}
