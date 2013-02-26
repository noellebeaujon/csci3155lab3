#!/usr/bin/env python
################################################################################
#
# File: submit.py
# Automatic CSCI 3155 form submitter.
#
# Copyright (c) 2013 Ken Sheedlo
# 
# Permission is hereby granted, free of charge, to any person obtaining a copy 
# of this software and associated documentation files (the "Software"), to deal 
# in the Software without restriction, including without limitation the rights 
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
# copies of the Software, and to permit persons to whom the Software is furnished 
# to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all 
# copies or substantial portions of the Software.
# 
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
# SOFTWARE.
# 
################################################################################

import getopt
import json
import sys
import urllib2

from MultipartPostHandler import MultipartPostHandler

CONFIG_FILENAME = 'submission.json'
POST_TARGET = 'http://csci3155.cs.colorado.edu/autograder/cgi-bin/testscalasubmission.py'

def submit_grading_request(request_args):
    '''
    Submits a request to the grading server.

    Returns an HTTPResponse.
    '''
    opener = urllib2.build_opener(MultipartPostHandler)
    params = dict(request_args)
    try:
        params['scalasubmission'] = open(request_args['scalasubmission'], 'rb')
        return opener.open(POST_TARGET, params)
    finally:
        params['scalasubmission'].close()

def usage(argv):
    '''
    Prints a usage string to the terminal.

    '''
    print 'Usage: {0} <options> submission_file'.format(argv[0])
    print 'Options:'
    print '     -c CONFIG_FILE  Use the specified JSON configuration options'
    print '     -f firstname    Your first name'
    print '     -l lastname     Your last name'
    print '     -k identikey    Your identikey'
    print '     -n assignment   Assignment number'
    print

def main(argv=None):
    if argv is None:
        argv = sys.argv

    options, args = [], []
    config = CONFIG_FILENAME
    request_opts = {}
    try:
        options, args = getopt.getopt(argv[1:], 'c:f:l:k:n:')
        for opt, arg in options:
            if opt == '-c':
                config = arg
    except getopt.GetoptError as err:
        usage(argv)
        return 2

    request_opt_names = (
            'firstname',
            'lastname',
            'identikey',
            'assignment',
            'scalasubmission'
        )
    with open(config, 'r') as f:
        config_options = json.load(f)
        for opt_name in request_opt_names:
            request_opts[opt_name] = config_options.get(opt_name, '')

    for opt, arg in options:
        if opt == '-f':
            request_opts['firstname'] = arg
        elif opt == '-l':
            request_opts['lastname'] = arg
        elif opt == '-k':
            request_opts['identikey'] = arg
        elif opt == '-n':
            request_opts['assignment'] = arg

    if len(args) > 0:
        request_opts['scalasubmission'] = args[0]

    try:
        response = submit_grading_request(request_opts)
        print reduce(lambda x, y: x+y, response.readlines())
    except urllib2.URLError as err:
        print str(err)
        return 4
    return 0


if __name__ == "__main__":
    sys.exit(main())
