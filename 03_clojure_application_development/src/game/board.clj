(ns game.board
  (:require
    [game.board-square :refer [square]]
    [game.board-dimensions :refer [max-board-squares]]
    ))

(defn- build-board []
  (for [i (range 0 max-board-squares)
    :let [s (square i)]]
  s))

(def game-board (vec (build-board)))

(defn get-board-square [s] (get game-board s))

(defn get-vector [s dir]
  (get (:dirs (get-board-square s)) dir))
