(ns game.chess.pieces-on-board
  (:require [game.board-foundation :refer [get-square-id]]
            [game.chess.piece :refer :all]))

(def pieces-on-board {})

(defn set-piece [s p] (def pieces-on-board (assoc pieces-on-board s p)))
