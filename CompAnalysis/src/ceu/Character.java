package ceu;

public class Character 
{
  private String charName;
  private String charRole;

  public Character( String charName, String charRole )
  {
    setCharName( charName );
    setCharRole( charRole );
  }

  public void setCharName( String charName )
  {
    this.charName = charName;
  }

  public void setCharRole( String charRole )
  {
    this.charRole = charRole;
  }

  public String getCharName()
  {
    return this.charName;
  }

  public String getCharRole()
  {
    return this.charRole;
  }
}
