(ns game.chess.actions
  (:require [game.board :refer [get-board-square]]
            [game.chess.pieces-on-board :refer :all]))

(defn- add-to [l s r]
  (assoc r l (conj (l r) s))
)

(defn- friend-or-foe [s c b]
  (if (= c (:color (get-piece s b))) "friend" "foe"))

(defn- add-friend-or-foe [s c r b]
  (if (= "friend" (friend-or-foe s c b))
    (add-to :friends s r)
    (add-to :foes s r)))

(defn action-map [v c b]
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

(defn merge-vector-in-maps
  [m1 m2 l]
  (assoc m1 l (concat (l m1) (l m2))))

(defn merge-action-maps
  ([m1 m2 m3 m4] (merge-action-maps (merge-action-maps m1 m2 m3) m4))
  ([m1 m2 m3] (merge-action-maps (merge-action-maps m1 m2) m3))
  ([m1 m2]
  (let [m1-moves (merge-vector-in-maps m1 m2 :moves)
        m1-friends (merge-vector-in-maps m1-moves m2 :friends)
        merged-map (merge-vector-in-maps m1-friends m2 :foes)] merged-map))
)

(defn get-dirs-map [s]
  (:dirs (get-board-square s)))

(defn get-dir-squares [s dir]
  (get (get-dirs-map s) dir))

(defn rook-actions [s c b]
  (let [N (get-dir-squares s :north)
        S (get-dir-squares s :south)
        E (get-dir-squares s :east)
        W (get-dir-squares s :west)
        north-map (action-map N c b)
        south-map (action-map S c b)
        east-map (action-map E c b)
        west-map (action-map W c b)
        ]
      (merge-action-maps north-map south-map east-map west-map)))
