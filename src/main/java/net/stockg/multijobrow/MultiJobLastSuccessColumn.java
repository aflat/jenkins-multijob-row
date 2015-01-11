/*
 * The MIT License
 *
 * Copyright 2015 gstockfisch.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.stockg.multijobrow;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Job;
import hudson.model.Run;
import hudson.scm.NullSCM;
import hudson.scm.SCM;
import hudson.triggers.SCMTrigger;
import hudson.triggers.TimerTrigger;
import hudson.triggers.Trigger;
import hudson.triggers.TriggerDescriptor;
import hudson.views.ListViewColumn;
import hudson.views.ListViewColumnDescriptor;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;
import static net.stockg.multijobrow.MultiJobColumn.LOGGER;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.export.Exported;

/**
 *
 * @author gstockfisch
 */
public class MultiJobLastSuccessColumn extends ListViewColumn{
    

    public static Logger LOGGER = Logger.getLogger(MultiJobLastSuccessColumn.class.getSimpleName());
	
	
    public String getMultiJobs(Job job){
       
    	return "multiJOBBBBB";
    }
        public String getDownstreamJobName(Job job){
        List<AbstractProject> jobs = Jenkins.getInstance().getDependencyGraph().getDownstream((AbstractProject) job);
        String jobName = new String();
        LOGGER.info("Upstream job name " + job.getName());
        if(null != jobs && jobs.size() > 0){
            LOGGER.info("Downstream job count " + Integer.toString(jobs.size()));
            jobName = jobs.get(0).getDisplayName();
        }
        LOGGER.info("Downstream job name " + jobName);
    	return jobName;
    }
    
    public AbstractProject getDownstreamJob(Job job){
        List<AbstractProject> jobs = Jenkins.getInstance().getDependencyGraph().getDownstream((AbstractProject) job);
        AbstractProject downstreamJob = null;
        
        LOGGER.info("Upstream job name " + job.getName());
        if(null != jobs && jobs.size() > 0){
            LOGGER.info("Downstream job count " + Integer.toString(jobs.size()));
            downstreamJob = jobs.get(0);
            
        }
        if(null != downstreamJob){
            LOGGER.info("Downstream job name " + downstreamJob.getDisplayName());
        }
    	return downstreamJob;
    }
    
    public String getJobStatusUrl(Job job) {
        LOGGER.info("Geting statusURL " + job.getBuildStatusUrl());
        LOGGER.info("Geting statusURL icon: " + job.getLastBuild().getBuildStatusIconClassName());
        return job.getBuildStatusUrl();
    }
    @Extension
    public static final class DescriptorImpl extends ListViewColumnDescriptor {
        @Override
        public ListViewColumn newInstance(StaplerRequest req, JSONObject formData){
        	return new MultiJobLastSuccessColumn();
        }
        
		@Override
		public String getDisplayName(){
			return "Downstream Job Last Success";
		}
        
        @Override
        public boolean shownByDefault() {
            return false;
        }
    }

}
