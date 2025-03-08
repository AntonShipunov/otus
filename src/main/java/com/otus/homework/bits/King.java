package com.otus.homework.bits;

public class King implements ChessPiece {

    @Override
    public long moves(int position) {
        long bb = 1L << position;
        long mask = (bb & 0x7F7F7F7F7F7F7F7FL) << 1;
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) >> 1;
        mask |= bb << 8;
        mask |= bb >> 8;
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) >> 9;
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) << 7;
        mask |= (bb & 0x7F7F7F7F7F7F7F7FL) << 9;
        mask |= (bb & 0x7F7F7F7F7F7F7F7FL) >> 7;
        return mask;
    }

    @Override
    public int countMoves(long moves) {
        return Long.bitCount(moves);
    }
}
