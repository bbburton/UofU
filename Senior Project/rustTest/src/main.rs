
// global constants are declared with the const keyword
const EX_WIDTH: u32 = 1;
const EX_HEIGHT: u32 = 4;

fn main() {
    // Line Comment
    
    /*
     * Multi-line Comment
     */
    print_hello();
    data_types();
    if_statements(0,1,2);
    if_statements(1,0,2);
    if_statements(0,0,0);
    looping();
    let x = 0;
    println!("x is {}", x);
    let x = add_one(x);
    println!("x is now {}", x);
    compound_types();
}

fn data_types() {
    /*
     * Primative data types:
     * unsigned:
     * u8
     * u16
     * u32
     * u64
     * u128
     * usize - the size of a pointer based on architecture
     *
     * signed:
     * i8
     * i16
     * i32 - default datatype
     * i64
     * i128
     * isize - like usize
     *
     * floating-point: represented according to the IEEE-754 standard
     * f32
     * f64 - default datatype
     *
     * bool: 
     * true
     * false
     *
     * char:
     * 'c', 'a', 'y', etc. is not limited to ascii values
     */
    let a_immut = "immutable"; // immutable
    let mut a_mut = 6; // mutable
    println!("a_immut: {}", a_immut);
    println!("a_mut: {}",a_mut);
    // This line will fail: a_immut = 7;
    // However this line will not:
    a_mut = 7;
    println!("Now a_mut is: {}",a_mut);
    // Rust allows shadowing which allows a variable to change datatypes and is done
    // with the let keyword and only with immutable variables
    let a_immut = a_immut.len();
    println!("a_immut: {}", a_immut);

    // You cannot assign one let operation to another: let x = (let y = 13); will fail
    // To explicitly declare a variable with a datatype declare the type with a : after
    // the variable name.
    
    let mut a0: u8 = 255;
    let mut a1: u16 = 65535;
    let mut a2: u32 = 4294967295;
    let mut a3: u64 = 18446744073709551615;
    let mut a4: u128 = 340282366920938463463374607431768211455;
    let mut a5: usize = 18446744073709551615;
     
    let mut a6: i8 = 127;
    let mut a7: i16 = 32767;
    let mut a8: i32 = 2147483647;
    let mut a9: i64 = 9223372036854775807;
    let mut a10: i128 = 170141183460469231731687303715884105727;
    let mut a11: isize = 9223372036854775807;
     
    let mut a12: f32 = 1.0;
    let mut a13: f64 = 2.0;

    println!("u8 max: {}", a0);
    println!("u16 max: {}", a1);
    println!("u32 max: {}", a2);
    println!("u64 max: {}", a3);
    println!("u128 max: {}", a4);
    println!("usize max: {}", a5);

    println!("i8 max: {}", a6);
    println!("i16 max: {}", a7);
    println!("i32 max: {}", a8);
    println!("i64 max: {}", a9);
    println!("i128 max: {}", a10);
    println!("isize max: {}", a11);

    println!("a12: {}", a12);
    println!("a13: {}", a13);

    // Values can be represented in multiple ways. All of the following are accpeted
    // ways of representing data in Rust.
    let dec0 = 789916;
    let dec1 = 789_916;
    let hex0 = 0xff;
    let oct0 = 0o77;
    let bin0 = 0b11110000;
    let bin1 = 0b1111_0000;
    let byte0 = b'A'; // u8 only.

    // Rust has all of the standard numerical and bit operations
    let addition = 0 + 1;
    let subtraction = 0 - 1;
    let multiplication = 1 * 2;
    let division = 56.7 / 32.2;
    let modulus = 43 % 5;

    println!("addition: {}", addition);
    println!("subtraction: {}", subtraction);
    println!("multiplication: {}", multiplication);
    println!("division: {}", division);
    println!("modulus: {}", modulus);

    let bitand = 0x0 & 0x1;
    let bitor = 0x0 ^ 0x1;
    let bitleft = 1 >> 0x10;
    let bitright = 1 << 1;

    println!("bitand: {}", bitand);
    println!("bitor: {}", bitor);
    println!("bitleft: {}", bitleft);
    println!("bitright: {}", bitright);

    // There are also boolean (bool) types
    let t = true;
    let f = false;
    println!("t is {}", t);
    println!("f is {}", f);

    // Finally, there is the char type that is the same
    // as in C, but includes more than standard ascii 
    // values.
    let a14 = 'b';
    println!("a14 is {}", a14);
}

fn if_statements(a0 : i32, a1 : i32, a2 : i32) {
    // if statements are the same as in C minus the (..)
    if a0 <= a1 {
        println!("{} is less than or equal {}", a0, a1);
    } else if a0 >= a1 {
        println!("{} is greater than or equal {}", a0, a1);
    }

    if a0 == a1 {
        println!("{} equals {}", a0, a1);
    } else if a0 > a1 {
        println!("{} is greater than {}", a0, a1);
    } else {
        println!("{} is less than {}", a0, a1);
    }
    
    // for multiple arguments for an if statement have 
    // the individual arguments in ()
    if (a0 < a1) && (a1 < a2) {
        println!("{} is in between {} and {}", a1, a0, a2);
    }
}

fn looping() {
    /*
     * for loops in rust behave like for each loops in 
     * other languages and to iterate with indexes you
     * must have a range declared wit lower..higher
     * to iterate over.
     */
    for i in 0..5 {
        println!("i is: {}", i);
    }
    /*
     * The above code is equal to the following code in 
     * C:
     * for(int i = 0; i < 5; i++) {
     *      printf("i is: %d\n", i);
     * }
     */

    /*
     * To iterate from a higher number to a lower you 
     * declare the range in () and then use the rev() 
     * function to reverse it.
     */
    for i in (0..5).rev() {
        println!("i is: {}", i);
    }
    /*
     * The above code is equal to the following code in 
     * C:
     * for(int i = 5; i > -1; --i) {
     *      printf("i is: %d\n", i);
     * }
     */
}

fn compound_types() {
    /*
     * There are two compound types in Rust: Tuples and Arrays.
     */
    /*
     * Tuples are created by putting values in () 
     * separated by ,'s. The values in the tuple do not 
     * need to be the same type.
     */
    let tup0 = (500, 6.4, 'a');
    // to declare specific types use the :
    let tup1 : (i8, char, bool, f32) = (4,'g',true,3.3);
    // To access the values in the tuple use the dot 
    // operator and the index.
    println!("tup1: ({},{},{},{})", tup1.0,tup1.1,tup1.2,tup1.3);
}

fn add_one(x : i32) -> i32 {
    /*
     * In Rust there is a difference between expressions 
     * and statements. Expressions return a value and 
     * do not end with a ';' and statements do not return
     * a value and end with a ';'. In a function that has
     * a return value the last line in the function must
     * be an expession or the code will fail.
     */
    x + 1
    /* 
     * There is a return keyword in Rust and can be used
     * to return a value from a function like in C, for 
     * example return x + 1; However, this format is 
     * considered bad form in Rust and the return keyword
     * is mainly used to return values early from a loop 
     * within a function.
     */
}

fn print_hello() {
    /*
     * If a function does not have a return type then 
     * it does not need an arrow to indicate one.
     */
    println!("Hello!");
}

/*
 * Rust has built in unit testing. To create a unit test
 * for your functions you create a function within the
 * same file as the function code with #[test] before
 * the unit test function. To perform your tests run:
 * cargo test
 */

#[test]
fn test_add_one() {
    assert_eq!(1, add_one(0));
}