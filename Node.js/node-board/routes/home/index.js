const express = require("express");
const router = express.Router();

// controller
const controller = require("./controller")

router.get("/", controller.hello);
router.get("/new", controller.createBoard);

module.exports = router;
