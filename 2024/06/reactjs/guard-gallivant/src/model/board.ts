export class Board {

    public readonly width: number;
    public readonly height: number;
    public readonly content: string;

    constructor(
        private inputString: string
    ) {
        this.width = this.inputString.split("\n")[0].length;
        this.height = this.inputString.split("\n").length;
        this.content = inputString.replace("^", ".");
    }

    isObstacle(x: number, y: number) {
        return this.inputString.split("\n")[y].charAt(x) == '#';
    }
}