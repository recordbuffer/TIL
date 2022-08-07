const hello = (req, res) => {
    res.render("home/index")
}

const createBoard = (req, res) => {
    res.render("home/createPage")
}

module.exports = {
    hello,
    createBoard
}