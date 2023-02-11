(defun factorial (n)
  (do ((i 1 (1+ i))
       (result 1 (* result i)))
      ((> i n) result)))
      
(print (factorial 50))

