/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.board;

/**
 *
 * @author Gustave Michel
 */
public class Board {
    private Space[] m_spaces;
    
    public Board() {
         m_spaces = new Space[9];
         for(int i = 0; i < m_spaces.length; i++) {
             if(m_spaces[i] == null) {
                 m_spaces[i] = new Space();
             }
             m_spaces[i].setState(Space.State.Empty);
         }
    }
    
    public void reset() {
        for(int i = 0; i < m_spaces.length; i++) {
            m_spaces[i].setState(Space.State.Empty);
        }
    }
    
    public void setSpace(int space, Space.State state) throws BoardOverwriteException {
        if((space <= 9 && space >= 1)) {
            if(state == Space.State.Empty) {
                m_spaces[space-1].setState(state);
            } else {
                if(m_spaces[space-1].getState() == Space.State.Empty) {
                    m_spaces[space-1].setState(state);
                } else {
                    throw new BoardOverwriteException();
                }
            }
        } else {
            throw new BoardOutOfBoundsException("Out of Board Bounds: "+String.valueOf(space));
        }
    }
    
    public void setSpaces(Space.State[] states) {
        if(states.length == 9) {
            for(int i = 0; i < m_spaces.length; i++) {
                m_spaces[i].setState(states[i]);
            }
        } else {
            throw new BoardOutOfBoundsException("Out of Board Bounds: "+String.valueOf(states.length));
        }
    }
    
    public Space.State getSpace(int space) {
        if(space <= 9 && space >= 1) {
            return m_spaces[space-1].getState();
        } else {
            throw new BoardOutOfBoundsException("Out of Board Bounds: "+String.valueOf(space));
        }
    }
    
    public Space.State[] getSpaces() {
        Space.State[] states = new Space.State[m_spaces.length];
        for(int i = 0; i < states.length; i++) {
            states[i] = m_spaces[i].getState();
        }
        return states;
    }
    
    public boolean isFull() {
        boolean noEmpty = true;
        for(int i = 0; i < m_spaces.length; i++) {
            if(m_spaces[i].getState() == Space.State.Empty) {
                noEmpty = false;
            }
        }
        return noEmpty;
    }
}
