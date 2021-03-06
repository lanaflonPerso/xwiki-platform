/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.xpn.xwiki.plugin.scheduler.internal;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version $Id$
 * @since 7.1M1
 */
public class StatusListener implements SchedulerListener, JobListener
{
    /**
     * Log4j logger that records events for this class
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusListener.class);

    @Override
    public void jobScheduled(Trigger trigger)
    {
        LOGGER.info("Task [{}] scheduled", trigger.getKey());
    }

    @Override
    public void jobUnscheduled(TriggerKey key)
    {
        LOGGER.info("Task [{}] unscheduled", key);
    }

    @Override
    public void triggerFinalized(Trigger trigger)
    {
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey)
    {
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey)
    {
    }

    @Override
    public void jobPaused(JobKey jobKey)
    {
        LOGGER.info("Task [{}] paused", jobKey);
    }

    @Override
    public void jobResumed(JobKey jobKey)
    {
        LOGGER.info("Task [{}] resumed", jobKey);
    }

    @Override
    public void schedulerError(String message, SchedulerException error)
    {
        LOGGER.error(message, error);
    }

    @Override
    public void schedulerShutdown()
    {
        LOGGER.warn("Scheduler is shutting down");
    }

    @Override
    public String getName()
    {
        return "StatusListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context)
    {
        LOGGER.info("Task [{}] is about to be executed", context.getJobDetail().getKey());
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context)
    {
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException e)
    {
        LOGGER.info("Task [{}] executed: ", context.getJobDetail().getKey(), e);
    }

    @Override
    public void triggersPaused(String triggerGroup)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void triggersResumed(String triggerGroup)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jobAdded(JobDetail jobDetail)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jobDeleted(JobKey jobKey)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jobsPaused(String jobGroup)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void jobsResumed(String jobGroup)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void schedulerInStandbyMode()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void schedulerStarted()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void schedulerStarting()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void schedulerShuttingdown()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void schedulingDataCleared()
    {
        // TODO Auto-generated method stub
        
    }
}
