/*
 * InstrumentationAgent.java
 *
 * Copyright by toolarium, all rights reserved.
 */
package com.github.toolarium.java.agent;

import java.lang.instrument.Instrumentation;

/**
 * Instrument agent adapted from blog post "Instrumentation: querying the memory usage of a Java object"
 * (http://www.javamex.com/tutorials/memory/instrumentation.shtml).
 * 
 * @author patrick
 */
public final class InstrumentationAgent {
    /** Handle to instance of Instrumentation interface. */
    private static volatile Instrumentation globalInstrumentation;

    
    /**
     * Constructor for InstrumentationAgent
     */
    private InstrumentationAgent() {
        // NOP
    }
    
    
    /**
     * Implementation of the overloaded premain method that is first invoked by
     * the JVM during use of instrumentation.
     * 
     * @param agentArgs Agent options provided as a single String.
     * @param inst Handle to instance of Instrumentation provided on command-line.
     */
    public static void premain(final String agentArgs, final Instrumentation inst) {
        globalInstrumentation = inst;
    }

    
    /**
     * Implementation of the overloaded agentmain method that is invoked for
     * accessing instrumentation of an already running JVM.
     * 
     * @param agentArgs Agent options provided as a single String.
     * @param inst Handle to instance of Instrumentation provided on command-line.
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        globalInstrumentation = inst;
    }

    
    /**
     * Get the initialised instrumentation
     * 
     * @return the instrumentation
     */
    public static Instrumentation getInstrumentation() {
        return globalInstrumentation;
    }
}


