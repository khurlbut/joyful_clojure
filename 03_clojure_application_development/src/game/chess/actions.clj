(ns game.chess.actions
  (:require [game.board :refer [get-square]]))
;
; (defn- get-squares [s d]
;   (d (:dirs (get-square s))))
(defn get-dirs-map [s]
  (:dirs (get-square s)))

(defn get-dir-squares [s dir]
  (get (get-dirs-map s) dir))

(defn rook-actions [s]
  (let [N (get-dir-squares s :north)
        S (get-dir-squares s :south)
        E (get-dir-squares s :east)
        W (get-dir-squares s :west)
        actions {:moves (vec (concat N S E W))}]
  actions)
)
