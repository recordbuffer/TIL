// 모듈
const express = require("express");
const app = express();

const PORT = 3010;

// 라우팅
const home = require("./routes/home");
app.use("/", home);

// 앱 세팅
app.set("views","./views");
app.set("view engine", "ejs");


app.listen(PORT, function() {
    console.log('서버 가동');
});
