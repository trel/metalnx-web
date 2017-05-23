/*
 * Copyright (c) 2015-2017, Dell EMC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.emc.metalnx.core.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class that represents a ticket.
 */
public class DataGridTicket implements Serializable {
    private String ticketString, path, owner;
    private TicketType type;
    private boolean isCollection;
    private int usesLimit;
    private Date expirationDate;
    private int usesCount;
    private long writeByteLimit;
    private long writeByteCount;
    private int writeFileLimit;
    private int writeFileCount;

    // Ticket restrictions
    private List<String> hosts;
    private List<String> users;
    private List<String> groups;

    public enum TicketType {
        READ, WRITE, UNKNOWN;
    }

    /**
     * Empty constructor
     */
    public DataGridTicket() {
        this("");
    }

    /**
     * Constructor.
     * @param path path in the grid that the ticket
     */
    public DataGridTicket(String path) {
        this.path = path;
        ticketString = "";
        owner = "";
        type = TicketType.READ;
        usesLimit = 0;
        writeByteLimit = 0;
        hosts = new ArrayList<>();
        users = new ArrayList<>();
        groups = new ArrayList<>();
    }

    public void addHost(String newHost) {
        if(hosts == null) hosts = new ArrayList<>();
        if(!hosts.contains(newHost)) hosts.add(newHost);
    }

    public void addUser(String user) {
        if(users == null) users = new ArrayList<>();
        if(!users.contains(user)) users.add(user);
    }

    public void addGroup(String group) {
        if(groups == null) groups = new ArrayList<>();
        if(!groups.contains(group)) groups.add(group);
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
    }

    public void setWriteFileLimit(int writeFileLimit) {
        this.writeFileLimit = writeFileLimit;
    }

    public void setWriteFileCount(int writeFileCount) {
        this.writeFileCount = writeFileCount;
    }

    public void setWriteByteLimit(long writeByteLimit) {
        this.writeByteLimit = writeByteLimit;
    }

    public void setWriteByteCount(long writeByteCount) {
        this.writeByteCount = writeByteCount;
    }

    public void setUsesCount(int usesCount) {
        this.usesCount = usesCount;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setUsesLimit(int usesLimit) {
        this.usesLimit = usesLimit;
    }

    public void setTicketString(String ticketString) {
        this.ticketString = ticketString;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    /**
     * Tells whether or not the ticket is for a collection.
     * @param isTicketForCollection True if the path associated to the ticket is a collection. False, otherwise.
     */
    public void setIsCollection(boolean isTicketForCollection) {
        isCollection = isTicketForCollection;
    }

    public List<String> getGroups() {
        return groups;
    }

    public List<String> getUsers() {
        return users;
    }

    public List<String> getHosts() {
        return hosts;
    }

    public int getWriteFileLimit() {
        return writeFileLimit;
    }

    public int getWriteFileCount() {
        return writeFileCount;
    }

    public long getWriteByteCount() {
        return writeByteCount;
    }

    public long getWriteByteLimit() {
        return writeByteLimit;
    }

    public int getUsesCount() {
        return usesCount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getUsesLimit() {
        return usesLimit;
    }

    public String getTicketString() {
        if(ticketString == null) ticketString = "";
        return ticketString;
    }

    public String getPath() {
        if(path == null) path = "";
        return path;
    }

    public String getOwner() {
        if(owner == null) owner = "";
        return owner;
    }

    public TicketType getType() {
        return type;
    }

    public boolean isCollection() {
        return isCollection;
    }

    @Override
    public String toString() {
        return "DataGridTicket{" +
                "ticketString='" + ticketString + '\'' +
                ", path='" + path + '\'' +
                ", owner='" + owner + '\'' +
                ", type=" + type +
                ", isCollection=" + isCollection +
                '}';
    }
}