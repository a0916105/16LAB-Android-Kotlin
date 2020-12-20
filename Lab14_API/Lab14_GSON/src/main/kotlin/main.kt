import com.google.gson.Gson

class Data{
    var myNumber = 0
    var myString = ""
}
fun main(args: Array<String>) {
    println("Gson的序列化(把物件轉成JSON字串)：")
    //1)建立一個物件，放入資料至物件中
    val data = Data()
    data.myNumber = 123
    data.myString = "abc"
    //2)使用Gson().toJson()把物件轉成JSON字串
    val json = Gson().toJson(data)
    println("json: $json")

    println("Gson的反序列化(把JSON字串轉成物件)：")
    //1)準備一個JSON字串
    val rJson = "{\"myNumber\":456,\"myString\":\"efg\"}"
    //2)使用Gson().fromJson()把JSON字串以Data格式做轉換並輸出物件
    val rData = Gson().fromJson(rJson, Data::class.java)
    println("myNumber: "+rData.myNumber+"\nmyString: "+rData.myString)
}