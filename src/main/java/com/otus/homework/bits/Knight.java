package com.otus.homework.bits;

public class Knight implements ChessPiece {

    @Override
    public long moves(int position) {
        long bb = 1L << position;
        long mask = 0;
        mask |= (bb & 0x7F7F7F7F7F7F7F7FL) << 17;
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) << 15;
        mask |= (bb & 0x7F7F7F7F7F7F7F7FL) >> 15;
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) >> 17;
        mask |= (bb & 0x3F3F3F3F3F3F3F3FL) << 10;
        mask |= (bb & 0xFCFCFCFCFCFCFCFCL) << 6;
        mask |= (bb & 0x3F3F3F3F3F3F3F3FL) >> 6;
        mask |= (bb & 0xFCFCFCFCFCFCFCFCL) >> 10;
        return mask;
    }

    @Override
    public int countMoves(long moves) {
        return Long.bitCount(moves);
    }
}
