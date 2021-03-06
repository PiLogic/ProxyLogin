package br.com.playdreamcraft.proxylogin.account;

import java.util.concurrent.TimeUnit;

import br.com.playdreamcraft.proxylogin.ProxyLogin;
import br.com.playdreamcraft.proxylogin.backend.DataProviderException;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Account
{	
		
	public long getLastSeen()
	{
		return lastSeen;
	}

	private String name;
	private String hash;
	private String email;
	
	private long lastSeen; // in minutes

	private ProxiedPlayer proxiedPlayer;
	private boolean logged;
	
	public Account(String name, String email, String password)
	{
		//TODO DISABLED JUST FOR TEST
		//this.proxiedPlayer = ProxyLogin.getInstance().getProxy().getPlayer(name);			
		this.email = email;
		this.hash = password;
		this.name = name;		
		lastSeen = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
	}
	
	public Account(ProxiedPlayer pp, String email, String password)
	{
		name = pp.getName().toLowerCase();		
		this.email = email;
		proxiedPlayer = pp;
		lastSeen = TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
	}
	
	public String getHash()
	{
		return hash;
	}

	public String getName()
	{
		return name;
	}
	
	public boolean isLogged() 
	{
		return logged;
	}

	public void setLogged(boolean logged) 
	{
		this.logged = logged;
	}

	public String getEmail() 
	{
		return email;
	}

	public ProxiedPlayer getProxiedPlayer() 
	{
		return proxiedPlayer;
	}	
	
	public void registrar()
	{
		try
		{
			AccountDataManager.getInstance().inserirConta(this);
		}catch (DataProviderException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void logar()
	{
		
	}
		
}
