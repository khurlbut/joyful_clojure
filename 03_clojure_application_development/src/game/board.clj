(ns game.board)

(def dimensions
  {
    :rows 8
    :cols 8})

(defn get-square [sq]
  (cond
    (< sq 0) nil
    (> sq 63) nil
    :else sq))

(defn get-row-num [sq]
  (let [sq (get-square sq)
        rows (float (dimensions :rows))
        row (/ sq rows)]
        (int row)))

(defn get-col-num [sq]
  (let [sq (get-square sq)
        cols (dimensions :cols)]
  (mod sq cols)))

(defn get-south-east-diag-num [sq]
  (+ (get-row-num sq) (get-col-num sq)))

(defn get-row-vector [sq]
  (let [row-num (get-row-num sq)]
    (case row-num
      7 [56 57 58 59 60 61 62 63]
      6 [48 49 50 51 52 53 54 55]
      5 [40 41 42 43 44 45 46 47]
      4 [32 33 34 35 36 37 38 39]
      3 [24 25 26 27 28 29 30 31]
      2 [16 17 18 19 20 21 22 23]
      1 [ 8  9 10 11 12 13 14 15]
      0 [ 0  1  2  3  4  5  6  7])))

(defn get-col-vector [sq]
  (let [col-num (get-col-num sq)]
    (case col-num
      0 [0  8 16 24 32 40 48 56]
      1 [1  9 17 25 33 41 49 57]
      2 [2 10 18 26 34 42 50 58]
      3 [3 11 19 27 35 43 51 59]
      4 [4 12 20 28 36 44 52 60]
      5 [5 13 21 29 37 45 53 61]
      6 [6 14 22 30 38 46 54 62]
      7 [7 15 23 31 39 47 55 63])))

(defn get-vector-east [num]
  (case num
    0 [1 2 3 4 5 6 7]
    8 [9 10 11 12 13 14 15]
  ))
