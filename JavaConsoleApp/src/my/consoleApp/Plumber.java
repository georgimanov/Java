package my.consoleApp;

import my.consoleApp.Systems.SystemA;

/******************************************************************************************************************
 * File:Plumber.java
 * Course: 17655
 * Project: Assignment 1
 * Copyright: Copyright (c) 2003 Carnegie Mellon University
 * Versions:
 *	1.0 November 2008 - Sample Pipe and Filter code (ajl).
 *
 * Description:
 *
 * This class serves as an example to illstrate how to use the PlumberTemplate to create a main thread that
 * instantiates and connects a set of filters. This example consists of three filters: a source, a middle filter
 * that acts as a pass-through filter (it does nothing to the data), and a sink filter which illustrates all kinds
 * of useful things that you can do with the input stream of data.
 *
 * Parameters: 		None
 *
 * Internal Methods:	None
 *
 ******************************************************************************************************************/
public class Plumber
{
    public static void main(String argv[])
    {
        String path1 = "dataSetsIn/FlightData.dat";
        String path2 = "dataSetsIn/SubSetA.dat";
        String path3 = "dataSetsIn/SubSetB.dat";

        SystemA systemA = new SystemA(path1, "dataSetsOut/OutputA.dat");
        systemA.start();

        /****************************************************************************
         * Here we instantiate three filters.
         ****************************************************************************/

        //SourceFilter sourceFilter = new SourceFilter();
        //MiddleFilter middleFilter = new MiddleFilter();
        //SinkFilter sinkFilterFirst = new SinkFilter();
        //SinkFilter sinkFilterSecond = new SinkFilter();

        /****************************************************************************
         * Here we connect the filters starting with the sink filter (Filter 1) which
         * we connect to Filter2 the middle filter. Then we connect Filter2 to the
         * source filter (Filter3).
         ****************************************************************************/

        //sinkFilterFirst.Connect(middleFilter); // This esstially says, "connect Filter3 input port to Filter2 output port
        //sinkFilterSecond.Connect(middleFilter);
        //middleFilter.Connect(sourceFilter); // This esstially says, "connect Filter2 intput port to sourceFilter output port

        /****************************************************************************
         * Here we start the filters up. All-in-all,... its really kind of boring.
         ****************************************************************************/

        //sourceFilter.start();
        //middleFilter.start();
        //sinkFilterFirst.start();
        //sinkFilterSecond.start();

    } // main

} // Plumber
