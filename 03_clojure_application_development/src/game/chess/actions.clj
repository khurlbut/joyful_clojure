(ns game.chess.actions
  (:require [game.board :refer [get-board-square]]
            [game.chess.pieces-on-board :refer :all]))

(defn- add-to [l s r]
  (assoc r l (conj (l r) s))
)

(defn- friend-or-foe [s c b]
  (if (= c (:color (get-piece b s))) "friend" "foe"))

(defn- add-friend-or-foe [s c r b]
  (if (= "friend" (friend-or-foe s c b))
    (add-to :friends s r)
    (add-to :foes s r)))

(defn get-vector-data [v c b]
  (let [colr c
        board b]
  (loop [remaining v results {}]
    (if (empty? remaining)
      results
      (let [s (first remaining)]
        (if (square-occupied s board)
          (add-friend-or-foe s colr results board)
          (let [next-remaining (rest remaining)
                next-results (add-to :moves s results)]
            (recur next-remaining next-results))))))))

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
