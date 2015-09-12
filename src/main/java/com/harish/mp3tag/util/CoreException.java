package com.harish.mp3tag.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CoreException extends Throwable
{
	private static final long serialVersionUID = 1L;
    static public String GetStack( Throwable E )
    {
        String szResult = "There was some error creating the Stack Frame";
        try
        {
            ByteArrayOutputStream Stack = new ByteArrayOutputStream();
            PrintStream PrintStack = null;
            if( Stack != null )
            {
                PrintStack = new PrintStream( Stack );
                if( PrintStack != null )
                {
                    E.printStackTrace( PrintStack );
                    szResult = Stack.toString();
                }
            }
        }
        catch( Exception e )
        {
            szResult += ( "\r\n\t"+e.toString() );
        }
        return "\r\n\t"+szResult;
    }
    public CoreException( int severity, String applicationName, String message )
    {
        this( severity, applicationName, message, false );
    }

    public CoreException( int severity, String applicationName, String message, boolean bPrintStack )
    {
        super( message );
        Logger.sysLog( severity, applicationName, message+(bPrintStack?GetStack( this ):"" ) );
    }
    public CoreException( int severity, String applicationName, String message, CoreException Module )
    {
        this( severity, applicationName, message, Module, false );
    }
    public CoreException( int severity, String applicationName, String message, CoreException Module, boolean bPrintStack )
    {
        super( message );
        if( ( applicationName != null ) && ( applicationName.length() != 0 ) )
            Logger.sysLog( severity, applicationName, message+(bPrintStack?GetStack( this ):"") );
        else
        	Logger.sysLog( severity, Module.getClass().getName(), message+(bPrintStack?GetStack( this ):"") );
    }
    public CoreException( int severity, String applicationName, String message, CoreException Module, String Parameter, String Value )
    {
        this( severity, applicationName, message, Module, Parameter, Value, false );
    }
    public CoreException( int severity, String applicationName, String message, CoreException Module, String Parameter, String Value, boolean bPrintStack )
    {
        super( message );
        if( ( applicationName != null ) && ( applicationName.length() != 0 ) )
        	Logger.sysLog( severity, applicationName, message+(bPrintStack?GetStack( this ):"") );
        else
        	Logger.sysLog( severity, Module.getClass().getName(), message+(bPrintStack?GetStack( this ):"") );
    }
}
