package com.spiderfrog.oldanimations.animations;

public enum EnumAnimation
{
    OLDBLOCKHIT("1.7 Blockhit", AnimationType.OLD), 
    OLDROD("1.7 Rod", AnimationType.OLD), 
    OLDBOW("1.7 Bow", AnimationType.OLD), 
    OLDDMG("1.7 Damage", AnimationType.OLD), 
    OLDHEARTS("1.7 Hearts", AnimationType.OLD), 
    OLDSNEAK("1.7 Sneak", AnimationType.OLD), 
    OLDBLOCKBUILD("1.7 Blockbreak", AnimationType.OLD), 
    OLDDEBUG("1.7 Debug Menu", AnimationType.OLD), 
    OLDEAT("1.7 Eat", AnimationType.OLD), 
    OLDPLAYERLIST("1.7 Playerlist", AnimationType.OLD), 
    OLDSWORD("1.7 Sword", AnimationType.OLD), 
    OLDITEMHELD("1.7 Itemheld", AnimationType.OLD), 
    OLDHITBOX("1.7 Hitbox", AnimationType.OLD), 
    OLDSWING("1.7 Swing", AnimationType.OLD), 
    OLDITEMUPDATE("1.7 Itemupdate", AnimationType.OLD), 
    OLDFASTITEMS("1.7 Itemdrop", AnimationType.OLD), 
    OLDCROSSHAIR("1.7 Crosshair", AnimationType.OLD), 
    OLDENCHGLINT("1.7 Enchglint", AnimationType.OLD), 
    OLDCOMMINGSOON("Comming Soon", AnimationType.OLD), 
    NOINVMOVE("NoInvMove", AnimationType.OTHER), 
    NOBOSSBAR("NoBossbar", AnimationType.OTHER), 
    NOINVBACKGROUND("NoInvBackground", AnimationType.OTHER), 
    OTHERCOMMINGSOON("Comming Soon", AnimationType.OTHER);
    
    private String name;
    private AnimationType type;
    
    private EnumAnimation(final String name, final AnimationType type) {
        this.name = name;
        this.type = type;
    }
    
    public String getVarName() {
        return this.name;
    }
    
    public String getLangCode() {
        return "" + this.name;
    }
    
    public AnimationType getType() {
        return this.type;
    }
    
    public enum AnimationType
    {
        OLD, 
        OTHER;
    }
}
