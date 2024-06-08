fn main() {
    for i in 1..10 {print!("{}", i);} // 123456789
    for i in (1..=9).rev() {print!("{}", i);} // 987654321 //closed range, reversed
}