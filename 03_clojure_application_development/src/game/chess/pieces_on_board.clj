(ns game.chess.pieces-on-board
  (:require [game.board-foundation :refer [get-square-id]]
            [game.chess.piece :refer :all]))

(def pieces-on-board {})

(defn set-piece
  ([s c r] (set-piece s (new-piece c r)))
  ([s p] (def pieces-on-board (assoc pieces-on-board s p)))
)

(defn remove-piece [s] (def pieces-on-board (dissoc pieces-on-board s)))
