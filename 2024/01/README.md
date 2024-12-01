# AoC 2024: Day 01



This was supposed to be only an initial "Proof of Concept" validation prepared in Libre Office Calc... but surprisingly such "Lean" solution turned out to be good enough also with the real data set.

As it works as expected, there no point in rewriting the spreadsheet into any "real" programming language.



|   | A | B | C                           | D                           | E           | F                    | G           |
|---|---|---|-----------------------------|-----------------------------|-------------|----------------------|-------------|
| 1 | 3 | 4 | =SMALL(\$A\$1:\$A\$6,ROW()) | =SMALL(\$B\$1:\$B\$6,ROW()) | =ABS(C1-D1) | =COUNTIF(D$1:D$6,C1) | =G1*C1      |
| 2 | 4 | 3 | =SMALL(\$A\$1:\$A\$6,ROW()) | =SMALL(\$B\$1:\$B\$6,ROW()) | =ABS(C2-D2) | =COUNTIF(D$1:D$6,C2) | =G2*C2      |
| 3 | 2 | 5 | =SMALL(\$A\$1:\$A\$6,ROW()) | =SMALL(\$B\$1:\$B\$6,ROW()) | =ABS(C3-D3) | =COUNTIF(D$1:D$6,C3) | =G3*C3      |
| 4 | 1 | 3 | =SMALL(\$A\$1:\$A\$6,ROW()) | =SMALL(\$B\$1:\$B\$6,ROW()) | =ABS(C4-D4) | =COUNTIF(D$1:D$6,C4) | =G4*C4      |
| 5 | 3 | 9 | =SMALL(\$A\$1:\$A\$6,ROW()) | =SMALL(\$B\$1:\$B\$6,ROW()) | =ABS(C5-D5) | =COUNTIF(D$1:D$6,C5) | =G5*C5      |
| 6 | 3 | 3 | =SMALL(\$A\$1:\$A\$6,ROW()) | =SMALL(\$B\$1:\$B\$6,ROW()) | =ABS(C6-D6) | =COUNTIF(D$1:D$6,C6) | =G6*C6      |
|   |   |   |                             | Part 1:                     | =SUM(E1:E6) | Part 2:              | =SUM(H1:H6) |

