(ns game.chess.pieces-on-board
  (:require
    [game.chess.piece :refer [new-piece]]
    ))

(def pieces-on-board {})

(defn set-piece
  ([s c r] (set-piece s (new-piece c r)))
  ([s p] (def pieces-on-board (assoc pieces-on-board s p)))
)

(defn remove-piece [s] (def pieces-on-board (dissoc pieces-on-board s)))

(defn get-piece [s b] (get b s))

(defn square-occupied [s b] (contains? b s))

(defn square-empty [s] (not (square-occupied s)))
