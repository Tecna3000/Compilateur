/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ABlocinst extends PBlocinst
{
    private TAco _aco_;
    private PListeinst _listeinst_;
    private TAcf _acf_;

    public ABlocinst()
    {
        // Constructor
    }

    public ABlocinst(
        @SuppressWarnings("hiding") TAco _aco_,
        @SuppressWarnings("hiding") PListeinst _listeinst_,
        @SuppressWarnings("hiding") TAcf _acf_)
    {
        // Constructor
        setAco(_aco_);

        setListeinst(_listeinst_);

        setAcf(_acf_);

    }

    @Override
    public Object clone()
    {
        return new ABlocinst(
            cloneNode(this._aco_),
            cloneNode(this._listeinst_),
            cloneNode(this._acf_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABlocinst(this);
    }

    public TAco getAco()
    {
        return this._aco_;
    }

    public void setAco(TAco node)
    {
        if(this._aco_ != null)
        {
            this._aco_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._aco_ = node;
    }

    public PListeinst getListeinst()
    {
        return this._listeinst_;
    }

    public void setListeinst(PListeinst node)
    {
        if(this._listeinst_ != null)
        {
            this._listeinst_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._listeinst_ = node;
    }

    public TAcf getAcf()
    {
        return this._acf_;
    }

    public void setAcf(TAcf node)
    {
        if(this._acf_ != null)
        {
            this._acf_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._acf_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._aco_)
            + toString(this._listeinst_)
            + toString(this._acf_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._aco_ == child)
        {
            this._aco_ = null;
            return;
        }

        if(this._listeinst_ == child)
        {
            this._listeinst_ = null;
            return;
        }

        if(this._acf_ == child)
        {
            this._acf_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._aco_ == oldChild)
        {
            setAco((TAco) newChild);
            return;
        }

        if(this._listeinst_ == oldChild)
        {
            setListeinst((PListeinst) newChild);
            return;
        }

        if(this._acf_ == oldChild)
        {
            setAcf((TAcf) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
