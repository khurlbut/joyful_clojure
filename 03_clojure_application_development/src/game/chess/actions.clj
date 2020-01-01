(ns game.chess.actions
  (:require [game.board :refer [get-board-square]]
            [game.chess.pieces-on-board :refer :all]))

(defn is-end-or-square-occupied [v]
  (if (or (empty? v) (square-occupied (first v))) true false)
)

(defn friend-or-foe [s c]
  (let [piece-on-square (get-piece s)
        color-of-piece (:color piece-on-square)]
        (if (= c color-of-piece) "friend" "foe")))

(defn categorize-occupant [s c results]
  (if (= "friend" (friend-or-foe s c))
    (assoc results :friends (conj (:friends results) s))
    (assoc results :foes (conj (:foes results) s))))

(defn get-vector-data [v c]
  (loop [remaining v results {} colr c]
    (if (empty? remaining)
      results
      (let [s (first remaining)]
        (if (square-occupied s)
          (categorize-occupant s colr results)
          (let [next-remaining (rest remaining)
                next-results (assoc results :moves (conj (:moves results) s))]
            (recur next-remaining next-results colr)))))))

(defn normalize [v c]
  (let [results (get-vector-data v c)
        moves (:moves results)]
   (assoc results :moves (rseq (vec moves)))))

;
; (defn- get-squares [s d]
;   (d (:dirs (get-board-squares))))
(defn get-dirs-map [s]
  (:dirs (get-board-square)))

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
