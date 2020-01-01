(ns game.chess.pieces-on-board
  (:require [game.board-foundation :refer [square-index]]
            [game.chess.piece :refer :all]))

(def pieces-on-board {})

(defn set-piece
  ([s c r] (set-piece s (new-piece c r)))
  ([s p] (def pieces-on-board (assoc pieces-on-board s p)))
)

(defn remove-piece [s] (def pieces-on-board (dissoc pieces-on-board s)))

(defn get-piece [s] (get pieces-on-board s))

(defn square-occupied [s] (contains? pieces-on-board s))

(defn square-empty [s] (not (square-occupied s)))
