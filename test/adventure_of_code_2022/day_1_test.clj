(ns adventure-of-code-2022.day-1-test
  (:require [clojure.test :refer :all]
            [adventure-of-code-2022.day-1 :as day-1]))

(deftest calories-counting-part-1-test
  (testing "Testing calories-counting-part-1"
    (let [input-1 (slurp "./resources/test/day_1/input1.txt")
          input-2 (slurp "./resources/test/day_1/input2.txt")]
      (is (= 24000 (day-1/calories-counting-part-1 input-1)))
      (is (= 65912 (day-1/calories-counting-part-1 input-2))))))

(deftest calories-counting-part-2-test
  (testing "Testing calories-counting-part-2"
    (let [input-1 (slurp "./resources/test/day_1/input1.txt")
          input-2 (slurp "./resources/test/day_1/input2.txt")]
      (is (= 45000  (day-1/calories-counting-part-2 input-1)))
      (is (= 195625 (day-1/calories-counting-part-2 input-2))))))
