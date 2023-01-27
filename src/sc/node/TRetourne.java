/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class TRetourne extends Token
{
    public TRetourne()
    {
        super.setText("retour");
    }

    public TRetourne(int line, int pos)
    {
        super.setText("retour");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TRetourne(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRetourne(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TRetourne text.");
    }
}