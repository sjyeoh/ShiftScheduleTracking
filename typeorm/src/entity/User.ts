import {Entity, PrimaryGeneratedColumn, Column} from "typeorm";

@Entity()
export class User {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    fullName: string;

    @Column()
    group: number;

    @Column()
    totalLeave: number;

    @Column()
    status: string;

    @Column()
    access: string;

    @Column({type:'date'})
    createdAt: Date;

    @Column()
    createdBy: string;

    @Column({type:'date'})
    updatedAt: Date;

    @Column()
    updatedBy: string;

    @Column()
    updateFrequency: number;

}
