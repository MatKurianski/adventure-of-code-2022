(ns adventure-of-code-2022.day-2-test
  (:require [clojure.test :refer :all]
            [adventure-of-code-2022.day-2 :as day-2]))

(deftest rock-paper-scissors-part-1-test
  (testing "Testing rock-paper-scissors-part-1"
    (let [input-1 (slurp "./resources/test/day_2/input1.txt")
          input-2 (slurp "./resources/test/day_2/input2.txt")]
      (is (= 15 (day-2/rock-paper-scissors-part-1 input-1)))
      (is (= 13446 (day-2/rock-paper-scissors-part-1 input-2))))))

(deftest rock-paper-scissors-part-2-test
  (testing "Testing rock-paper-scissors-part-2"
    (let [input-1 (slurp "./resources/test/day_2/input1.txt")
          input-2 (slurp "./resources/test/day_2/input2.txt")]
      (is (= 12  (day-2/rock-paper-scissors-part-2 input-1)))
      (is (= 13509 (day-2/rock-paper-scissors-part-2 input-2))))))
