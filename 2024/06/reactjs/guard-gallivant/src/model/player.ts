
type PlayerDirection = '^' | '>' | 'v' | '<';

export class Player {

    public readonly x: number;
    public readonly y: number;
    public readonly d: PlayerDirection;

    constructor(x: number, y: number, d: PlayerDirection) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

// constructor(
    //     private inputString: string
    // ) {
    //     {
    //         this.x, this.y, this.d
    //     }
    //     = this.findPlayer(inputString);
    //     // this.width = this.inputString.split("\n")[0].length;
    //     // this.height = this.inputString.split("\n").length;
    // }

    public static fromTheInputBoard(inputString: string) {
        let lines = inputString.split('\n');
        for (let y = 0; y < lines.length; y++) {
            let line = lines[y];
            for (let x = 0; x < line.length; x++) {
                if (['^', '>', 'v', '<'].includes(line[x])) {
                    return new Player(x, y, line[x] as PlayerDirection);
                }
            }
        }
        // return undefined;
        throw new Error('Player not found in the input string');
    }
}