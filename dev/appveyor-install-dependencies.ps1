<#
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
#>

# create tools directory outside of REEF directory
$up = (Get-Item -Path ".." -Verbose).FullName
$tools = "$up\tools"
if (!(Test-Path $tools))
{
    New-Item -ItemType Directory -Force -Path $tools | Out-Null
}

# ========================== maven
Push-Location $tools

$mavenVer = "3.3.3"
Start-FileDownload "https://archive.apache.org/dist/maven/maven-3/$mavenVer/binaries/apache-maven-$mavenVer-bin.zip" "maven.zip"

# extract
Invoke-Expression "7z.exe x maven.zip" | Out-Null

# add maven to environment variables
$env:Path += ";$tools\apache-maven-$mavenVer\bin"
$env:M2_HOME = "$tools\apache-maven-$mavenVer"

Pop-Location

# ========================== protoc
$protocVer = "2.5.0"
$protocPath = "$tools\protoc-$protocVer"
if (!(Test-Path $protocPath))
{
    New-Item -ItemType Directory -Force -Path $protocPath | Out-Null
}
Push-Location $protocPath

Start-FileDownload "https://github.com/google/protobuf/releases/download/v$protocVer/protoc-$protocVer-win32.zip" "protoc.zip"

# extract
Invoke-Expression "7z.exe x protoc.zip" | Out-Null

# add protoc to environment variables
$env:Path += ";$protocPath"

Pop-Location

# ========================== xUnit console runner
$root = (Get-Item -Path "." -Verbose).FullName
$packages = "$root\lang\cs\packages"
Invoke-Expression "nuget install .\lang\cs\.nuget\packages.config -o $packages"
