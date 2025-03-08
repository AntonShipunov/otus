package com.otus.homework.bits;

public interface ChessPiece {

    long moves(int position);
    int countMoves(long moves);
}
