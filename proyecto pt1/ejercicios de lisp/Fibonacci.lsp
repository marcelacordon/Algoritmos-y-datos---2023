(defun fibonacci (n)
  (do ((i 0 (+ i 1))
       (current 1 (if (= i 0) 0 (if (= i 1) 1 (+ previous current))))
       (previous 0 current))
      ((= i n) current)))

(print (fibonacci 10))
