#!/bin/bash -e
#
# Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved.
#
# This program and the accompanying materials are made available under the
# terms of the Eclipse Distribution License v. 1.0, which is available at
# http://www.eclipse.org/org/documents/edl-v10.php.
#
# SPDX-License-Identifier: BSD-3-Clause

# Arguments:
#  N/A
echo '-[ Stable Jakarta EE Specification Build ]--------------------------------------'
mvn -U -C -Psnapshots,oss-release -Dstatus='DRAFT' -pl spec clean install deploy
echo '-[ Stable Jakarta EE API Build ]------------------------------------------------'
mvn -U -C -Psnapshots,staging,oss-release -pl api clean install deploy
