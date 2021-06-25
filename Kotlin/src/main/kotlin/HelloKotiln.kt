fun main(){
    println("Hello, World")
}
fun main(args: Array<String>) {
    //args (인자) 호출하기 위해선 미리 넣어줘야함
    //1. Edit configuration
    //2. Program arguments 에 넣기 Ok
    //3. 실행...
    println(args[1])
    println(args[2])
    println(args[3])

    //4. 변수 표현 실행...
    println("args[0] = ${args[0]}")

}