export class Board {

    private readonly OBSTACLE_CHARACTER = '#';
    
    public readonly width: number;
    public readonly height: number;
    public readonly content: string;

    constructor(
        private inputString: string
    ) {
        this.width = this.inputString.split("\n")[0].length;
        this.height = this.inputString.split("\n").length;
        this.content = inputString.replace(/[<>^v]/g, '.');
    }

    isObstacle(x: number, y: number) {
        if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
            return false;
        }
        return this.inputString.split("\n")[y].charAt(x) == this.OBSTACLE_CHARACTER;
    }
}