

# Planning 

## Part 1

Background:
- https://adventofcode.com/2024/day/6

Steps:

- initialize new react app (setup local tools if needed)

- create board component - render board and player (hardcoded so far, invent initial data model)

- game state - encapsulate basic board responsibilies (reset, get board and get player or board with player) from 13:45 do 14:10

- implement "move" command (including UI) - 14:10 do 14:40

- implement "is player within board" query

- implement "count visited positions" query

- cover with game-loop


Technical notes:

- Game State
    - command: reset board (initially hardcoded)
    - command: move
    - query: get player
    - query: is player within
    - query: count positions
    - state: board
    - state: player (x, y, d)
    - state: visited positions


## Part 2

### Attempt 1
- if was here -> there will be a loop
- if was "above" (in the turned direction there's a journey to the same direction) -> there could be a loop too

### Attempt 2
As above, and:
- looped if on player's right there's already a walked path (check if was before on the his right from current x and y   

### Attempt 3 (brute-force - success)

Test for loop: 
- set stone at XY
- run the game until:
  - guard is following in his old footsteps/tracks --> the loop 
  - guard left the board --> no loop

- 130 x 130 = 16 900 possible locations to check 
- it gave a correct answer

### Attempt 4

Extend the search condition with further right turns - this should increase the computiational complexity only lineary. 

### Attempt 5

Compare what differs results from algorithmic and brute-force approaches.

Findings: algorithm gives too many possible obstacles:
- a cause of "grandpa paradox" in the past - setting an obstacle in the places that were already walked would impact the remaining part of the path, so it should not be done
- a cause of "grandpa paradox" in the assumed loop cause by the obstacle - setting an obstacle should impact the assumed path

That led to the proper result algorithmically too.

# Other observations

- I'm not React dev, the might look a bit Angular-ish or a bit backend-ish :)
- I haven't managed to implement quickly a form to edit a board data
- I haven't managed to develop CLI variant of the app (each attempt to run it like `ts-node some-file.ts` ended in various error: mostly regarding the modules or the import paths)
- brute-force variant is kept in source code and its execution is left commented out in the `index.tsx` 