package br.com.playdreamcraft.proxylogin.security.passwords.hash;

public enum HashTypes
{

	SHA256(HashSHA256.getInstance());
	
	private PasswordHash passwordHash;
	
	HashTypes(PasswordHash passwordHash)
	{
		this.passwordHash = passwordHash;
	}
	
	public PasswordHash getPasswordHash()
	{
		return passwordHash;	
	}	
}
