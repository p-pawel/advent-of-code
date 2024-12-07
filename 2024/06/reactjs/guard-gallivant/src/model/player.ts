type PlayerDirection = '^' | '>' | 'v' | '<';

export class Player {

    public readonly x: number;
    public readonly y: number;
    public readonly d: PlayerDirection;

    public constructor(x: number, y: number, d: PlayerDirection) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public static fromTheInputBoard(inputString: string) {
        const lines = inputString.split('\n');
        for (let y = 0; y < lines.length; y++) {
            const line = lines[y];
            for (let x = 0; x < line.length; x++) {
                if (['^', '>', 'v', '<'].includes(line[x])) {
                    return new Player(x, y, line[x] as PlayerDirection);
                }
            }
        }
        throw new Error('Player not found in the input string');
    }

    forward(): Player {
        const [moveX, moveY] = this.calcMove(this.d);
        return new Player(this.x + moveX, this.y + moveY, this.d);
    }

    backward(): Player {
        const [moveX, moveY] = this.calcMove(this.d);
        return new Player(this.x - moveX, this.y - moveY, this.d);
    }

    turnRight() {
        return new Player(
            this.x, this.y, this.calcRotate(this.d)
        );
    }

    calcRotate(d: PlayerDirection): PlayerDirection {
        switch (d) {
            case "^":
                return ">";
            case ">":
                return "v";
            case "v":
                return "<";
            case "<":
                return "^";
        }
    }

    private calcMove(d: PlayerDirection): number[] {
        switch (d) {
            case "^":
                return [0, -1];
            case ">":
                return [1, 0];
            case "v":
                return [0, 1];
            case "<":
                return [-1, 0];
        }
    }
}