(ns adventure-of-code-2022.day-6-test
  (:require [clojure.test :refer :all]
            [adventure-of-code-2022.day-6 :as day-6]))

(deftest tuning-trouble-part-1-test
  (testing "Testing tuning-trouble-part-1"
    (let [input-1 (slurp "./resources/test/day_6/input1.txt")
          input-2 (slurp "./resources/test/day_6/input2.txt")]
      (is (= 7 (day-6/tuning-trouble-part-1 input-1)))
      (is (= 1361 (day-6/tuning-trouble-part-1 input-2))))))

(deftest tuning-trouble-part-2-test
  (testing "Testing tuning-trouble-part-2"
    (let [input-1 (slurp "./resources/test/day_6/input1.txt")
          input-2 (slurp "./resources/test/day_6/input2.txt")]
      (is (= 19 (day-6/tuning-trouble-part-2 input-1)))
      (is (= 3263 (day-6/tuning-trouble-part-2 input-2))))))
