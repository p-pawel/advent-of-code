import {describe, expect, it} from "@jest/globals";
import {Player} from "@/model/player";

describe('Player', () => {

    it('should find Player in the example board', async () => {

        // arrange

        const inputString =
            "....#.....\n" +
            ".........#\n" +
            "..........\n" +
            "..#.......\n" +
            ".......#..\n" +
            "..........\n" +
            ".#..^.....\n" +
            "........#.\n" +
            "#.........\n" +
            "......#...";


        // act

        const player: Player | undefined = Player.fromTheInputBoard(inputString);

        // assert

        expect(player).toEqual(
            {
                x: 4,
                y: 6,
                d: '^'
            }
        );

    });
    
    it('should find Player in the small board', async () => {

        // arrange

        const inputString =
            "...\n" +
            ".>.\n" +
            "...\n";


        // act

        const player: Player | undefined = Player.fromTheInputBoard(inputString);

        // assert

        expect(player).toEqual(
            {
                x: 1,
                y: 1,
                d: '>'
            }
        );

    });

});