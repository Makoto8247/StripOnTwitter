
private fun fail():Nothing{
    throw Exception("願いは20文字まで入力してください。\n名前は10文字まで入力してください。")
}

fun main() {
    val strip = Array(14,{arrayOfNulls<Char>(7)})
    var wish:String
    var name:String
    val tag = "#七夕\n#短冊"

    // 枠を作る
    strip[0][0] = '┏'
    strip[0][6] = '┓'
    strip[13][0] = '┗'
    strip[13][6] = '┛'
    strip[1][3] = '〇'
    for(i in 1..5){
        strip[0][i] = '━'
        strip[13][i] = '━'
    }
    for(i in 1..12){
        strip[i][0] = '┃'
        strip[i][6] = '┃'
    }
    try{
        println("願いを入力してください。(20文字以内):")
        val wish_input:String? = readLine()
        wish = wish_input?.also{
            if(wish_input.length <= 20){
                wish_input.toString().toUpperCase()
            }else{
                fail()
            }
        }?:run{
            fail()
        }
        println("名前を入力してください。(10文字以内):")
        val name_input = readLine()
        name = name_input?.also{
            if(name_input.length <= 10){
                name_input.toString().toUpperCase()
            }else{
                fail()
            }
        }?:run{
            fail()
        }
        if(wish.length <= 10){
            for(i in 0..(wish.length-1)){
                strip[i+3][3] = wish[i]
            }
        }else{
            for(i in 0..9){
                strip[i+3][5] = wish[i]
            }
            for(i in 10..(wish.length-1)){
                strip[i-7][3] = wish[i]
            }
        }
        val st_name = 13 - name.length
        for(i in 0..(name.length-1)){
            strip[st_name+i][1] = name[i]
        }

        println("↓Twitterにコピペしよう↓")
        for(i in 0..13){
            for(j in 0..6){
                strip[i][j]?.also{
                    print(strip[i][j].toString().toUpperCase())
                }?:run{
                    print("　")
                }
            }
            println()
        }
        println(tag)
    }catch(e:Exception){
        println(e)
    }catch(e:ArrayIndexOutOfBoundsException){
        println("予期せぬエラーが発生しました。")
    }finally{
    }
}
