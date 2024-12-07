export class Point {
    public readonly x: number;
    public readonly y: number;

    constructor(x: number, y: number) {
        if (x == 26 && y == 27) {
            console.error("26,77");
            // throw new Error('54,54');
        }
        this.x = x;
        this.y = y;
    }
}