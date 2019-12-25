(ns main
  (:require [clojure.string :as string]))

(defn add-7
  [num]
  (let [answer (+ num 7)]
    answer))

(defn hypotenuse
  "Calculates the hypotenuse of a right triangle"
  [side1 side2]
  (let [a-squared (* side1 side1)
        b-squared (* side2 side2)
        c-squared (+ a-squared b-squared)]
    (Math/sqrt c-squared)))

(def users
  [{:id 1 :age 31
    :first-name "Daniel" :last-name "King"}
   {:id 2 :age 16
    :first-name "Angel" :last-name "Herrera"}
   {:id 3 :age 31
    :first-name "Jane" :last-name "Smith"}
   {:id 4 :age 20
    :first-name "Ruth" :last-name "Langley"}])

;; WARNING: This is wrong
(defn get-eligible-user-ids
  [users]
  (let [results []]
    (doseq [user users]
      (if (>= (get user :age) 21)
        (conj results (get user :id))))
    results))

(defn get-eligible-user-ids-1
  [users]
  (loop [remaining users
         results []]
    (if (empty? remaining)
      results
      (let [user (first remaining)
            next-remaining (rest remaining)
            next-results (if (>= (get user :age) 21)
                           (conj results (get user :id))
                           results)]
        (recur next-remaining next-results)))))

(defn get-eligible-user-ids-2
  [users]
  (map (fn [user] (get user :id))
       (filter (fn [user] (>= (get user :age) 21)) users)))

(defn get-eligible-user-ids-3
  [users]
  (reduce conj []
          (map (fn [user] (get user :id))
               (filter (fn [user] (>= (get user :age) 21)) users))))

(defn get-eligible-user-ids-4
  [users]
  (into []
        (map (fn [user] (get user :id))
             (filter (fn [user] (>= (get user :age) 21)) users))))

(defn get-eligible-user-ids-5
  [users]
  (->> users
       (filter (fn [user] (>= (get user :age) 21)))
       (map (fn [user] (get user :id)))
       (into [])))

(def users-table
  {:users-list ["123" "456"]
   :users-by-id {"123" {:id "123"
                        :first-name "Daniel"}
                 "456" {:id "456"
                        :first-name "Jane"}}})
(defn add-new-user
  [users-table user]
  (let [id (get user :id)]
    (-> users-table
        (assoc-in [:users-by-id id] user)
        (update :users-list conj id))))

;; Exercises

(defn get-full-name
  "Gets the full name (first name and last name)
  of a user.

  Example:
  (get-full-name {:first-name \"Daniel\" :last-name \"King\"})
  -> \"Daniel King\""
  [user]
    (let [first-name (get user :first-name)
          last-name (get user :last-name)]
      (str first-name " " last-name)
    )
  )

"Given a vector of users, returns a list of the users' ids."

(defn get-ids-0
  "Solution 0 - using loop/recur"
  [users]
  (loop [remaining-users users
         user-ids []]
    (if (empty? remaining-users)
      user-ids
      (let [user (first remaining-users)
            next-remaining-users (rest remaining-users)
            next-user-ids (conj user-ids (get user :id))]
         (recur next-remaining-users next-user-ids)))))

(defn get-ids-1
  "Solution 1 - less verbose loop/recur"
  [users]
  (loop [remaining-users users
         ids []]
    (if (empty? remaining-users)
      ids
      (recur (rest remaining-users) (conj ids (get (first remaining-users) :id))))))

(defn get-ids-2
  "Solution 2 - using map (returns 'lazy sequence)"
  [users]
  (map (fn [user] (get user :id)) users))

(defn get-ids-3
  "Solution 3 - using into map (returns concrete vector)"
  [users]
  (into [] (map (fn [user] (get user :id)) users)))

(defn get-ids-4
  "Solution 4 - using thread-last macro (returns concrete vector)"
  [users]
  (->> users
       (map (fn [user] (get user :id)))
       (into [])))

 (defn get-ids-5
   "Solution 5 - Even Better! Thread-last macro with keyword used as function!"
   [users]
   (->> users
        (map :id)
        (into [])))

"Given an http request, returns the response that should be
sent back to the client.

Example request:
{:method :GET :url \"/hello\"}

Example response:
{:status 200 :body \"Hello world\"}

The handler should support the following routes:
- GET /hello (responds with \"Hello world\")
- GET /goodbye (responds with \"Goodbye world\")

Any other request should result in a 404 response
with the text \"Not found\" in the body."

(defn http-handler-0
  "Solution 0 - Straigt forward usage of 'cond' (multi-branch 'if')"
  [req]
  (let [method (get req :method)
        url (get req :url)]
    (cond
       (and (= method :GET) (= url "/hello"))
          {:status 200 :body "Hello World!"}
       (and (= method :GET) (= url "/goodbye"))
          {:status 200 :body "Goodbye World!"}
       :else
          {:status 404 :body "Not Found"})))

(defn http-handler-1
  "Solution 1 - better way to extract the request params ('desructuring')"
  [req]
  (let [{:keys [method url]} req]
    (cond
      (and (= method :GET) (= url "/hello"))
        {:status 200 :body "Hello World!"}
      (and (= method :GET) (= url "/goodbye"))
        {:status 200 :body "Goodbye World!"}
      :else
        {:status 404 :body "Not Found"})))

(defmulti http-handler-2
  "Solution 2 - Use a 'multimethod'"
  (fn [req] [(get req :method) (get req :url)]))

(defmethod http-handler-2 [:GET "/hello"]
  [req]
  {:status 200 :body "Hello World!"})

(defmethod http-handler-2 [:GET "/goodbye"]
  [req]
  {:status 200 :body "Goodbye World!"})

(defmethod http-handler-2 :default
  [req]
  {:status 404 :body "Not Found"})

"Gets the sum of a sequence of numbers. Non-positive numbers
should not be included in the sum.

Example:
(total-of-positives [1 5 -10 3 -2])
-> 9"
(defn total-of-positives-0
  [nums]
  (loop [remaining nums
         total 0]
    (if (empty? remaining)
      total
      (let [next-num (first remaining)
            next-remaining (rest remaining)
            next-total (if (> next-num 0)
              (+ total next-num)
              total)]
        (recur next-remaining next-total)))))

(defn total-of-positives-1
  [nums]
  (->> nums
    (filter (fn [num] (> num 0)))
    (reduce +)))


"Determines whether or not a given string is a palindrome.

Examples:
(is-palindrome \"Hello\") -> false
(is-palindrome \"abcba\") -> true
Challenge: (is-palindrome \"Taco Cat\") -> true"
(defn is-palindrome-0
  "Solution 0 - my first attempt - only partially works.
   Fails on Taco Cat - attempt to manage whitespace does not work!."
  [str]
  (if (= str (string/reverse (string/lower-case (string/replace str " " ""))))
    true
    false))

(defn is-palindrome-1
  "Solution 1 - uses generic recursion (no recur/loop!)
   Fails on Taco Cat - makes no attempt to manage caps/whitespace)"
  [str]
  (if (empty? str)
    true
    (and (= (first str) (last str))
         (is-palindrome-1 (butlast (rest str))))))

(defn is-palindrome-2
  "Solution 2 - use built in reverse function (requires sequence)
   Fails on Taco Cat - makes no attempt to manage caps/whitespace"
  [str]
  (= (sequence str) (reverse str)))

(defn is-palindrome-3
  "Solution 3 - same approach as my first attempt, but more explicit.
   Copied from solutions.clj.
   Notice the use of thread-first macro!"
  [str]
  (let [cleaned-string (-> str
                           (string/upper-case)
                           (string/replace " " ""))]
  (= (sequence cleaned-string) (reverse cleaned-string))))

(defn is-palindrome-4
  "Solution 4 - Use reverse from sting package. Removes the need for sequence."
  [str]
  (let [cleaned-string (-> str
                           (string/upper-case)
                           (string/replace " " ""))]
  (= cleaned-string (string/reverse cleaned-string))))

"Takes a word and a number, and rotates each letter in the word
that many characters forward in the alphabet, wrapping around from
Z back to A.

Examples:
(caesar-encrypt \"abc\" 3) -> \"def\"
(caesar-encrypt \"Zebra\" 4) -> \"Difve\"

Note: The name of the function comes from the fact that this transformation
is known as a Caesar Cipher."

(def alphabet "abcdefghijklmnopqrstuvwxyz")

(defn rotate-character
  [character rotation-num]
  (let [lower-character (string/lower-case character)
       index (string/index-of alphabet lower-character)
       rotated-index (mod (+ index rotation-num) (count alphabet))
       rotated-character (str (nth alphabet rotated-index))]
    (println (= (str character) (str lower-character)))
    (if (= character lower-character)
      rotated-character
      (string/upper-case rotated-character))))

(defn caesar-encrypt
  [word num-places]
  (->> word
       (map (fn [char] (rotate-character (str char) num-places)))
       (string/join "")))
