(ns game.chess.actions_foundation
  (:require [game.board :refer [get-board-square]]
            [game.chess.pieces-on-board :refer :all]))

(defn- add-to [l s r]
  (assoc r l (conj (l r) s))
)

(defn- friend-or-foe [s c b]
  (if (= c (:color (get-piece s b))) "friend" "foe"))

(defn- add-friend-or-foe [s c m b]
  (if (= "friend" (friend-or-foe s c b))
    (add-to :friends s m)
    (add-to :foes s m)))

(defn- merge-vector-in-maps
  [m1 m2 v]
  (assoc m1 v (vec (concat (v m1) (v m2)))))

(defn build-action-map [v c b]
  (let [colr c
        board b]
  (loop [remaining v action-map {}]
    (if (empty? remaining)
      action-map
      (let [s (first remaining)]
        (if (square-occupied s board)
          (add-friend-or-foe s colr action-map board)
          (let [next-remaining (rest remaining)
                next-results (add-to :moves s action-map)]
            (recur next-remaining next-results))))))))

(defn get-vector [s dir]
  (get (:dirs (get-board-square s)) dir))

(defn merge-maps
  ([m1 m2]
  (let [g1 (merge-vector-in-maps m1 m2 :moves)
        g2 (merge-vector-in-maps g1 m2 :friends)
        g3 (merge-vector-in-maps g2 m2 :foes)]
   g3)))
